import './App.css';
import CourseList from './components/CourseList';
import Header from './components/Header';
import Navbar from './components/Navbar';

function App() {
  return (
    <div className='container-fuild'>
      
      <div className='row'>
        <div className='col-12 my-header'>
          <Header />
        </div>
      </div>
      
      <div className='row'>
        <div className='col-3 my-nav'>
          <Navbar />
        </div>

        <div className='col-9 my-courses'>
          <CourseList />
        </div>

      </div>
      
    </div>
  );
}

export default App;
