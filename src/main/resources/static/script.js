document.addEventListener('DOMContentLoaded', function() {
    fetchBooks();
});

function fetchBooks() {
    fetch('/api/books') // Assuming your API endpoint is '/api/books'
        .then(response => response.json())
        .then(data => displayBooks(data))
        .catch(error => console.error('Error fetching books:', error));
}

function displayBooks(books) {
    const booksContainer = document.getElementById('books-container');
    books.forEach(book => {
        const bookElement = document.createElement('div');
        bookElement.classList.add('book');
        bookElement.innerHTML = `
            <h2>${book.title}</h2>
            <p>Author: ${book.author.name}</p>
            <p>Category: ${book.category.name}</p>
            <p>Review: ${book.review.content}</p>
            <!-- Add more details as needed -->
        `;
        booksContainer.appendChild(bookElement);
    });

}
function displayBooks(books) {
    const booksContainer = document.getElementById('books-container');
    books.forEach(book => {
        const bookElement = document.createElement('div');
        bookElement.classList.add('book');
        bookElement.innerHTML = `
            <h2>${book.title}</h2>
            <p>Author: ${book.authorName}</p>
        `;
        booksContainer.appendChild(bookElement);
    });
}

