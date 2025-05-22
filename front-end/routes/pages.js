const express = require('express');
const router = express.Router();

router.get('/', (req, res) => {
  res.render('index'); 
});

router.get('/cadastro-cliente', (req, res) => {
  res.render('cadastro-cliente'); 
});

router.get('/cadastro-produto', (req, res) => {
  res.render('cadastro-produto'); 
});

router.get('/cadastro-fornecedor', (req, res) => {
  res.render('cadastro-fornecedor'); 
});

module.exports = router;