const express = require('express');
const axios = require('axios');
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

router.get('/chamar-backend-java', async (req, res) => {
  try {
    const response = await axios.get('http://localhost:8080/api');
    res.json({ resposta: response.data });
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao chamar backend Java' });
  }
});

module.exports = router;