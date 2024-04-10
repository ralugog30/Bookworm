document.addEventListener('DOMContentLoaded', function() {
    fetchBooks();

    // Add event listener for button click
    const button = document.querySelector('.button');
    button.addEventListener('click', handleButtonClick);
});


function fetchBooks() {
    fetch('/api/books')
        .then(response => response.json())
        .then(data => displayBooks(data))
        .catch(error => console.error('Error fetching books:', error));
}

function displayBooks(books) {
    const booksContainer = document.getElementById('books-container');
    books.forEach(book => {
        const bookElement = document.createElement('div');
        bookElement.classList.add('book');

        const checkbox = document.createElement('input');
        checkbox.type = 'checkbox';
        checkbox.value = book.id;
        checkbox.name = 'selectedBooks';

        const label = document.createElement('label');
        label.textContent = book.title;

        bookElement.appendChild(checkbox);
        bookElement.appendChild(label);

        const authorElement = document.createElement('p');
        authorElement.textContent = `Author: ${book.author.name}`;
        bookElement.appendChild(authorElement);

        booksContainer.appendChild(bookElement);
    });
}

function getSelectedBookIds() {
    const checkboxes = document.querySelectorAll('input[name="selectedBooks"]:checked');
    const selectedBookIds = [];
    checkboxes.forEach(checkbox => {
        selectedBookIds.push(Number(checkbox.value)); // Convert value to BigInt
    });
    return selectedBookIds;
}
/*
function displayFilteredBooks(books) {
    console.log('Received filtered books:', books); // Add this line for debugging

    const booksContainer = document.getElementById('books-container');

    // Clear the booksContainer before displaying new suggestions
    booksContainer.innerHTML = '';

    books.forEach(book => {
        const bookElement = document.createElement('div');
        bookElement.classList.add('book');

        // Display only title and author
        bookElement.innerHTML = `
            <h2>${book.title}</h2>
            <p>Author: ${book.author.name}</p>
        `;

        booksContainer.appendChild(bookElement);
    });
}

 */









function handleButtonClick() {
    // Get the list of selected book IDs
    const selectedBooks = getSelectedBookIds();

    const qs = selectedBooks.join(",")

    // Send a POST request to the backend with the selected book IDs
    fetch('/api/books/suggestions?selectedBooks=' + qs, {
        headers: {
            'Content-Type': 'application/json'
        },
    })
        .then(response => response.json())
        .then(data => displayFilteredBooks(data))
        .catch(error => console.error('Error filtering books:', error));
}


function displayFilteredBooks(books) {
    console.log('Received filtered books:', books); // Add this line for debugging

    const booksContainer = document.getElementById('books-container');

    // Clear the booksContainer before displaying new suggestions
    booksContainer.innerHTML = '';

    books.forEach(book => {
        const bookElement = document.createElement('div');
        bookElement.classList.add('book');

        // Display only title and author
        bookElement.innerHTML = `
            <h2>${book.title}</h2>
            <p>Author: ${book.author.name}</p>
            <button class="specification-button">?</button> <!-- Add question mark button -->
        `;

        // Add event listener to the button to toggle visibility of specifications
        const button = bookElement.querySelector('.specification-button');
        button.addEventListener('click', () => moreSpecifications(book, bookElement));

        booksContainer.appendChild(bookElement);
    });
}

function moreSpecifications(book, bookElement) {
    const specificationsElement = document.createElement('div');
    specificationsElement.classList.add('specifications');
    specificationsElement.innerHTML = `
        <p>Category: ${book.category.type}</p>
        <p>Review: ${book.review.comment}</p>
        <p>Rating: ${book.review.rating}</p>
        <p>Description: ${book.specifications.description}</p>
        <!-- Add more specifications as needed -->
    `;

    const existingSpecifications = bookElement.querySelector('.specifications');
    if (existingSpecifications) {
        existingSpecifications.remove(); // Remove existing specifications if any
    } else {
        bookElement.appendChild(specificationsElement); // Append specifications if not already visible
    }
}


