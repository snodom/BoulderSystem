import React from "react";
import SmallBoard from '../../components/smallBoard/SmallBoard';
import "./BoulderListPage.css";
import Searcher from '../../components/searcher/Searcher';
import boulderApi from '../../api/boulderApi.js';
import Spinner from "../../components/spinner/Spinner.js";


class BoulderListPage extends React.Component {

    constructor(props) {
        super(props);
        this.state =   {
           search: props.name,
           boulderList: [],
           boulderListToShow: [],
           loading: true,
           filterName: '',
           filterGrade: '',
        };
      
      
      }

    componentDidMount() {
        this.getBoulderList();

    }

    getBoulderList = async () => {
        const response = await boulderApi.getBoulderList()
        this.setState({ boulderList: response.data });
        this.setState({loading: false});
      
    }

     filterName = (name) => {
        this.setState({
            filterName:name
        });
    }

    filterGrade = (grade) => {
          this.setState({
            filterGrade:grade
        });
    }
    

    render() {
      
        this.state.boulderListToShow = this.state.boulderList.filter(el => ((el.grade == this.state.filterGrade || this.state.filterGrade == "") && el.name.includes(this.state.filterName))).map(el => <SmallBoard name = {el.name} grade={el.grade} key = {el.iD}  holds = {el.holdDtoList}  id= {el.iD} author = {el.author}/>)

        if (this.state.loading){
          return (
            <div>
                <div className = "searchers">
                    <Searcher name = "name" handleChange = {this.filterName}/>
                    <Searcher name = "grade" handleChange = {this.filterGrade}/>
                </div>
                <Spinner style={{position: "fixed", left: "50%", top: "50%", transform: "translate(-50%, -50%"}}/> : 
            </div>
        );
        }

        return (
            <div>
                <div className = "searchers">
                    <Searcher name = "name" handleChange = {this.filterName}/>
                    <Searcher name = "grade" handleChange = {this.filterGrade}/>
                </div>
                <div className="boardList">
                   {this.state.boulderListToShow}
                </div>  
            </div>
        );
    };

}

export default BoulderListPage;
