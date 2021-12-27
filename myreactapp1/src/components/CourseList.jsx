//rcc
import React, { Component } from 'react';

class CourseList extends Component {

    state = {
        courses : [
            { _id: 1, title : 'java', description : 'java course description .. sample text', fees : 1000.00, trainer : 'vishaal'},
            { _id: 2, title : 'Spring', description : 'Spring course description .. sample text', fees : 4000.00, trainer : 'vishaal'},
            { _id: 3, title : 'Angular', description : 'Angular course description .. sample text', fees : 5000.00, trainer : 'vishaal'},
            { _id: 4, title : 'React', description : 'React course description .. sample text', fees : 2000.00, trainer : 'vishaal'},
        ]
    }

    handleAddCourse = () => {
        console.log('adding a new course')
        let newItem =   { _id: 5, title : 'NodeJS', description : 'NodeJS course description .. sample text', fees : 2000.00, trainer : 'vishaal'}
        // this.state.courses.push(newCourse)

        let newCourses = [ ...this.state.courses, newItem ]
        this.setState({
            courses : newCourses
        })
    }

    handleRemoveCourse = (course) => {
        console.log('removing course ', course)
        const courses = this.state.courses.filter(c => c._id !== course._id)
        this.setState({courses})
    }

    
    render() {
        return (
            <div>
              <h1>Course List....</h1>  
              <button onClick={ this.handleAddCourse } className="btn btn-primary">Add Course</button>
              <div>
              {
                  this.state.courses.map((course)=> (
                            <div key={course._id} className="card" style={ {width: '18rem', height:'300px', margin:'5px', display:'inline-block'} }>
                                <img src="..." className="card-img-top" alt="..." />
                                <div className="card-body"> 
                                    <h5 className="card-title">{ course.title }</h5>
                                    <p className="card-text">{course.description} Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                    <a href="#" className="btn btn-primary">Enroll Now!</a>
                                    <button onClick={ ()=> this.handleRemoveCourse(course) } className="btn btn-danger">Remove</button>
                                </div>
                            </div>
                        )
                  )
              }
              </div>

            </div>
        );
    }
}

export default CourseList;