import React from "react";
import { Route } from "react-router";
import { Routes } from "react-router-dom";

//import DodajHiso from "../Hise/DodajHiso";
//import Hise from "../Hise/Hise";
import PageNotFound from "../pageNotFound/PageNotFound";
import Vaje from "../Vaje/Vaje";
import DodajVajo from "../Vaje/DodajVajo";
import PosodobiVajo from "../Vaje/PosodobiVajo";
import Vadbe from "../Vadbe/Vadbe";
import DodajVajoVadbi from "../Vaje/DodajVajoVadbi";
import DodajVadbo from "../Vadbe/DodajVadbo";
import PosodobiVadbo from "../Vadbe/PosodobiVadbo";
import IsciVajo from "../Vaje/IskanjeVaje";
import PraviceUporabnika from "../UpravljanjePravic/PraviceUporabnika";

export default function Routing(){
    return(
        <Routes>
            <Route path="/vaje" element={<Vaje />}/>
            <Route path="/vaje/dodaj" element={<DodajVajo />}/>
            <Route path="/vaje/:id/posodobi" element={<PosodobiVajo />}/>
            <Route path="/vadbe" element={<Vadbe />}/>
            <Route path="/vadbe/:id/dodajVajoVadbi" element={<DodajVajoVadbi />}/>
            <Route path="/vadbe/dodaj" element={<DodajVadbo />}/>
            <Route path="/vadbe/:id/posodobi" element={<PosodobiVadbo />}/>
            <Route path="/vaje/isci" element={<IsciVajo />}/>
            <Route path="/uporabnik/:id/pravice" element={<PraviceUporabnika />}/>
            <Route path="*" element={<PageNotFound />}/>
        </Routes>
    );
}