import * as React from 'react';
import { Button } from "@mui/material";
import { Link } from "react-router-dom";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import api from "../../services/api";


import VajeVadbe from "../Vaje/VajeVadbe";

export default function VadbeTabela({vadbe}) {
  const odstraniVadbo = (vadbaId) => {
    api.delete("/vadba/"+vadbaId).then((result) => console.log(result.data));
    window.location.reload();
  }

  const urlPosodobiVadbo = (vadbaId) => {
    return "/vadbe/"+vadbaId+"/posodobi";
  }

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Id</TableCell>
            <TableCell align="right">Naziv</TableCell>
            <TableCell align="right">Število intervalov</TableCell>
            <TableCell align="right">Stanje</TableCell>
            <TableCell align="right">Čas objave</TableCell>
            <TableCell align="right">Javno</TableCell>
            <TableCell align="right">Vaje</TableCell>
            <TableCell align="right">Uredi</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {vadbe.map((vadba) => (
            <TableRow
              key={vadba.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {vadba.id}
              </TableCell>
              <TableCell align="right">{vadba.naziv}</TableCell>
              <TableCell align="right">{vadba.stIntervalov}</TableCell>
              <TableCell align="right">{vadba.stanje ? "Opravljeno" : "Neopravljeno"}</TableCell>
              <TableCell align="right">{new Date(vadba.casObjave).toLocaleString()}</TableCell>
              <TableCell align="right">{vadba.javno ? "✔️" : "❌"}</TableCell>
              <TableCell align="right">{<VajeVadbe vadbaId={vadba.id} />}</TableCell>
              <TableCell align="right">
                <Button variant="contained" onClick={()=>{odstraniVadbo(vadba.id)}}>Odstrani vadbo</Button>
                <Link to={urlPosodobiVadbo(vadba.id)}><Button variant="contained">Posodobi vadbo</Button></Link>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}