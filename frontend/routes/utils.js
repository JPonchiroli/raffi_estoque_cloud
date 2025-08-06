const express = require('express');
const axios = require('axios');
const router = express.Router();

router.get('/chamar-backend-java', async (req, res) => {
  try {
    const response = await axios.get('http://backend:8080/api');
    res.json({ resposta: response.data });
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao chamar backend Java' });
  }
});

router.get('/buscar-endereco-backend/:cep', async (req, res) => { 
  const { cep } = req.params;

  try {
    const response = await axios.get(`http://backend:8080/api/address/get-address/${cep}`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Não foi possível buscar o endereço.' });
  }
});

module.exports = router;