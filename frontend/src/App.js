import React, { Component } from 'react';
import './App.scss';
import {Preview} from "./components/Preview/Preview";
import {PreviewRow} from "./components/PreviewRow/PreviewRow";

class App extends Component {
  render() {
    return (
      <div className="App">
        <PreviewRow >
          <Preview title="A botkormanyos" />
          <Preview title="A botkormanyos 2" />
          <Preview title="A botkormanyos ujra lecsap" />
        </PreviewRow>
      </div>
    );
  }
}

export default App;
