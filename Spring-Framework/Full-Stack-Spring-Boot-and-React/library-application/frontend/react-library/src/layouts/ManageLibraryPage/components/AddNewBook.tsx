import { useOktaAuth } from '@okta/okta-react';
import { useState } from 'react';
import AddBookRequest from '../../../models/AddBookRequest';

export const AddNewBook = () => {
  const { authState } = useOktaAuth();

  // New Book
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [description, setDescription] = useState('');
  const [copies, setCopies] = useState(0);
  const [category, setCategory] = useState('Category');
  const [selectedImage, setSelectedImage] = useState<any>(null);

  // Display
  const [displayWarning, setDisplayWarning] = useState(false);
  const [displaySuccess, setDisplaySuccess] = useState(false);

  function categoryField(value: string) {
    setCategory(value);
  }

  // Convert Image to Base64
  async function base64ConversionImages(e: any) {
    if (e.target.files[0]) {
      getBase64(e.target.file[0]);
    }
  }

  function getBase64(file: any) {
    let reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = () => {
      setSelectedImage(reader.result);
    };

    reader.onerror = (error) => {
      console.error('Error', error);
    };
  }

  async function submitNewBook() {
    const url = `http://localhost:8080/api/admin/secure/add/book`;
    if (
      authState?.isAuthenticated &&
      title !== '' &&
      author !== '' &&
      category !== 'Category' &&
      description !== '' &&
      copies > 0
    ) {
      const book: AddBookRequest = new AddBookRequest(
        title,
        author,
        description,
        copies,
        category
      );
      book.img = selectedImage;
      const requestOptions = {
        method: 'POST',
        headers: {
          Authorization: `Bearer ${authState?.accessToken?.accessToken}`,
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(book),
      };

      const submitNewBookResponse = await fetch(url, requestOptions);

      if (!submitNewBookResponse.ok) {
        throw new Error('Something went wrong!');
      }

      setTitle('');
      setAuthor('');
      setDescription('');
      setCopies(0);
      setCategory('Category');
      setSelectedImage(null);
      setDisplayWarning(false);
      setDisplaySuccess(true);
    } else {
      setDisplayWarning(true);
      setDisplaySuccess(false);
    }
  }

  return (
    <div className='container mt-5 mb-5'>
      {displaySuccess && (
        <div
          className='alert alert-success'
          role='alert'
        >
          Book added successfully
        </div>
      )}
      {displayWarning && (
        <div
          className='alert alert-danger'
          role='alert'
        >
          All fields must be filled out
        </div>
      )}
      <div className='card'>
        <div className='card-header'>Add a new book</div>
        <div className='card-body'>
          <form method='POST'>
            <div className='row'>
              <div className='col-md-6 mb-3'>
                <label className='form-label'>Title</label>
                <input
                  className='form-control'
                  type='text'
                  name='title'
                  onChange={(e) => setTitle(e.target.value)}
                  value={title}
                  required
                />
              </div>
              <div className='col-md-3 mb-3'>
                <label className='form-label'>Author</label>
                <input
                  className='form-control'
                  type='text'
                  name='author'
                  onChange={(e) => setAuthor(e.target.value)}
                  value={author}
                  required
                />
              </div>
              <div className='col-md-3 mb-3'>
                <label
                  htmlFor=''
                  className='form-label'
                >
                  Category
                </label>
                <button
                  className='form-control btn btn-secondary dropdown-toggle'
                  id='dropdownMenuButton1'
                  type='button'
                  data-bs-toggle='dropdown'
                  aria-expanded='false'
                >
                  {category}
                </button>
                <ul
                  className='dropdown-menu'
                  id='addNewBookId'
                  aria-labelledby=' dropdownMenuButton1'
                >
                  <li>
                    <span
                      className='dropdown-item'
                      onClick={() => categoryField('FE')}
                    >
                      Front-End
                    </span>
                  </li>
                  <li>
                    <span
                      className='dropdown-item'
                      onClick={() => categoryField('BE')}
                    >
                      Back-End
                    </span>
                  </li>
                  <li>
                    <span
                      className='dropdown-item'
                      onClick={() => categoryField('Data')}
                    >
                      Data
                    </span>
                  </li>
                  <li>
                    <span
                      className='dropdown-item'
                      onClick={() => categoryField('DevOps')}
                    >
                      DevOps
                    </span>
                  </li>
                </ul>
              </div>
            </div>
            <div className='col-md-12 mb-3'>
              <label className='form-label'>Description</label>
              <textarea
                className='form-control'
                id='exampleFormControlTextarea1'
                rows={3}
                onChange={(e) => setDescription(e.target.value)}
                value={description}
              />
            </div>
            <div className='col-md-3 mb-3'>
              <label className='form-label'>Copies</label>
              <input
                className='form-control'
                type='test'
                name='Copies'
                onChange={(e) => setCopies(Number(e.target.value))}
                value={copies}
                required
              />
            </div>
            <input
              type='file'
              onChange={(e) => base64ConversionImages(e)}
            />
            <div>
              <button
                className='btn btn-primary mt-3'
                type='button'
                onClick={submitNewBook}
              >
                Add Book
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
