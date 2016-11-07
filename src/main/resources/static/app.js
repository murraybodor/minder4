const React = require('react');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {people: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/people'}).done(response => {
			this.setState({people: response.entity._embedded.people});
		});
	}

	render() {
		return (
			<PeopleList people={this.state.people}/>
		)
	}
}

class PeopleList extends React.Component{
	render() {
		var people = this.props.people.map(person =>
			<Person key={person._links.self.href} person={person}/>
		);
		return (
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
				{people}
			</table>
		)
	}
}

class Person extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.person.firstName}</td>
				<td>{this.props.person.lastName}</td>
			</tr>
		)
	}
}

React.render(
	<App />,
	document.getElementById('react')
)