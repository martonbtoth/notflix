import React from "react";
import './Block.scss'


const Block = ({ children, vertical }) => (
    <div className={(vertical ? "vertical " : "") + "block"}>
        {children}
    </div>
);

export default Block;