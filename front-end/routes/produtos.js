const express = require('express');
const axios = require('axios');
const router = express.Router();



router.get('/listar-produtos-backend', async (req, res) => {
  try {
    const response = await axios.get('http://localhost:8080/api/produtos/get-all-produtos');
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar produtos do backend Java' });
    console.error(error.message);
  }
});

router.delete('/deletar-produto-backend/:id', async (req, res) => {
  const { id } = req.params;
  if (!id) {
    return res.status(400).json({ erro: 'ID do produto é obrigatório' });
  }

  try {
    const response = await axios.delete(`http://localhost:8080/api/produtos/deletar-produto/${id}`);
    res.json({ mensagem: 'Produto deletado com sucesso', dados: response.data });
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao deletar produto do backend Java' });
  }
});

module.exports = router;