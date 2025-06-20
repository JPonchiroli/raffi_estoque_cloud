const express = require('express');
const axios = require('axios');
const router = express.Router();


router.post('/cadastrar-venda-backend', async (req, res) => {
  const { codCliente, itens } = req.body;

  try {
    const resposta = await axios.post('http://localhost:8080/api/vendas/create-venda', {
      codCliente,
      itens
    });

    res.status(resposta.status).json({ mensagem: 'Venda cadastrada com sucesso!' });
  } catch (erro) {
    console.error('Erro ao enviar venda para o backend:', erro.message);
    res.status(500).json({ erro: 'Erro ao cadastrar venda' });
  }
});

router.get('/listar-vendas-backend', async (req, res) => {
  try {
    const response = await axios.get('http://localhost:8080/api/vendas/get-all-vendas');
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
    const response = await axios.delete(`http://localhost:8080/api/vendas/delete-venda/${id}`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao deletar venda do backend Java' });
    console.error(error.message);
  }
});


module.exports = router;