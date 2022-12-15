import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";

//import DodajHiso from "../Hise/DodajHiso";
//import Hise from "../Hise/Hise";
import PageNotFound from "../pageNotFound/PageNotFound";

export default function Routing(){
    return(
        <Routes>
            <Route path="*" element={<PageNotFound />}/>
        </Routes>
    );
}