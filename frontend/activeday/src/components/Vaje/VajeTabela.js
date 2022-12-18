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

export default function VajeTabela({vaje}) {

  const odstraniVajo = (vajaId) => {
    api.delete("/vaja/"+vajaId).then((result) => console.log(result.data));
    window.location.reload();
  }

  const urlPosodobiVajo = (vajaId) => {
    return "/vaje/"+vajaId+"/posodobi";
  }

  return (
    <TableContainer component={Paper}>
      <Table sx={{ minWidth: 650 }} aria-label="simple table">
        <TableHead>
          <TableRow>
            <TableCell>Id</TableCell>
            <TableCell align="right">Naziv</TableCell>
            <TableCell align="right">Opis</TableCell>
            <TableCell align="right">Število ponovitev</TableCell>
            <TableCell align="right">Čas trajanja</TableCell>
            <TableCell align="right">Stanje</TableCell>
            <TableCell align="right">Uredi</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {vaje.map((vaja) => (
            <TableRow
              key={vaja.id}
              sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
            >
              <TableCell component="th" scope="row">
                {vaja.id}
              </TableCell>
              <TableCell align="right">{vaja.naziv}</TableCell>
              <TableCell align="right">{vaja.opis}</TableCell>
              <TableCell align="right">{vaja.stPonovitev}</TableCell>
              <TableCell align="right">{vaja.casTrajanja+" sec"}</TableCell>
              <TableCell align="right">{vaja.stanje ? "Opravljeno" : "Neopravljeno"}</TableCell>
              <TableCell align="right">
                <Button variant="contained" onClick={()=>{odstraniVajo(vaja.id)}}>Odstrani vajo</Button>
                <Link to={urlPosodobiVajo(vaja.id)}><Button variant="contained">Posodobi vajo</Button></Link>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
  );
}
