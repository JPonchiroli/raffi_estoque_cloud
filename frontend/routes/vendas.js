const express = require('express');
const axios = require('axios');
const router = express.Router();


router.post('/cadastrar-venda-backend', async (req, res) => {
  const { codCliente, itens } = req.body;

  try {
    const resposta = await axios.post('http://backend:8080/api/vendas/create-venda', {
      codCliente,
      itens
    });

    res.status(resposta.status).json({ mensagem: 'Venda cadastrada com sucesso!' });
  } catch (error) {
    console.error('Erro ao cadastrar venda no backend Java:', error);

    if (error.response) {
      res.status(error.response.status).json({
        erro: error.response.data.message || 'Erro ao cadastrar venda no backend Java (resposta com erro)'
      });
    } else if (error.request) {
      res.status(500).json({
        erro: 'Nenhuma resposta recebida do backend Java. Verifique se ele está online.'
      });
    } else {
      res.status(500).json({
        erro: 'Erro interno ao configurar a requisição para o backend Java.'
      });
    }
  }
});

router.get('/listar-vendas-backend', async (req, res) => {
  try {
    const response = await axios.get('http://backend:8080/api/vendas/get-all-vendas');
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar vendas do backend Java' });
    console.error(error.message);
  }
});

router.get('/listar-itens-vendas-backend/:codVenda', async (req, res) => {
  const { codVenda } = req.params;
  if (!codVenda) {
    return res.status(400).json({ erro: 'ID da venda é obrigatório' });
  }

  try {
    const response = await axios.get(`http://backend:8080/api/vendas/get-itens-venda/${codVenda}`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar vendas do backend Java' });
    console.error(error.message);
  }
});

router.delete('/deletar-venda-backend/:id', async (req, res) => {
  const { id } = req.params;
  if (!id) {
    return res.status(400).json({ erro: 'ID da venda é obrigatório' });
  }

  try {
    const response = await axios.delete(`http://backend:8080/api/vendas/delete-venda/${id}`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao deletar venda do backend Java' });
    console.error(error.message);
  }
});


module.exports = router;