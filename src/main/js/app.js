import React from 'react'
import ReactDOM from 'react-dom';
import Menu from './menu.js';


class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            data: [],
        };
    }

    componentDidMount() {
        fetch('api/notes')
            .then(res => res.json())
            .then((data) => {
                this.setState({ data })
            })
            .catch(console.log)
    }
    render() {
        console.log(this.state.data);
        console.log("test");
        return (
            <Menu></Menu>
    );

    }
}
class NotesList extends React.Component{
    render() {
        const notes = this.props.notes.map(note =>
            <Note key={note.id} note={note}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>Title</th>
                    <th>Content</th>
                </tr>
                {notes}
                </tbody>
            </table>
        )
    }
}
class Note extends React.Component{
    render() {
        return (
            <tr>
                <td>{this.props.note.title}</td>
                <td>{this.props.note.content}</td>
            </tr>
        )
    }
}
ReactDOM.render(<App/>,document.getElementById('react'));

