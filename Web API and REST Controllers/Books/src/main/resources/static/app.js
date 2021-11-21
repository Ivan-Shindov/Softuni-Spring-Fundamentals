//TODO polojenieto e kritichno

let table = '';
let firstName = '';
let lastName = '';
let bookId = undefined;
let inputTitle = document.getElementById('title');
let inputAuthor = document.getElementById('author');
let inputIsbn = document.getElementById('isbn');


document.getElementById('body')
    .addEventListener('click', function (ev) {
            if (ev.target.id === 'loadBooks') {
                $('tbody').empty()

                fetch('http://localhost:8080/books')
                    .then(response => response.json())
                    .then(json => json.forEach(book => {

                        firstName = book.author.firstName;
                        lastName = book.author.lastName;
                        bookId = book.id;

                        table = `<tr>
                <td>${bookId}</td>
                <td id="title">${book.title}</td>
                <td>${firstName} ${lastName}</td>
                <td>${book.isbn}</td>
                <td>
                    <button id="edit">Edit</button>
                    <button id="delete">Delete</button>
                </td>
            </tr>`

                        $('tbody').append(table);
                    }));

            } else if(ev.target.id === 'title') {
                inputTitle.value = ev.target.textContent;
                inputAuthor.value = ev.target.nextSibling.textContent;
                inputIsbn.value = ev.target.nextSibling.textContent;
            }
        }
    )


document.getElementById('container').addEventListener(
    'submit', function (event) {

        event.preventDefault();
        console.log(event.target)
        if (event.target.id === 'edit') {
            console.log(2222)
        }
    });
