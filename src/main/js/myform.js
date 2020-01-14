import React from 'react'
import './css/formstyle.css';
class MyForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: '',
            content: ''
        };
        this.titleChange = this.titleChange.bind(this);
        this.contentChange = this.contentChange.bind(this);
    }
    titleChange(event) {
        this.setState({title: event.target.value});
    }

    contentChange(event) {
        this.setState({content: event.target.value});
    }
    sendRequest = e => {
        e.preventDefault();
        console.log(this.state.title);
        console.log(this.state.content);
        fetch('api/notes', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                title: this.state.title,
                content: this.state.content,
            })
        }).catch(console.log)
    };
    render() {
        let header = '';
        if (this.state.username) {
            header = <h1>Hello </h1>;
        } else {
            header = '';
        }
        return (
            <form>
                {header}
                <p>Wprowadź tytuł notatki:</p>
                <input type="text" id="first" value={this.state.title}  onChange={this.titleChange}  />
                <p>Wprowadź treść notatki</p>
                <textarea id="second" value={this.state.content}  onChange={this.contentChange} />
                <button type="submit" id="click" onClick={this.sendRequest}>Submit</button>
            </form>
        );
    }
}
export default MyForm;