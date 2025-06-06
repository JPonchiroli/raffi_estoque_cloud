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

router.get('/listar-clientes', (req, res) => {
  res.render('listar-clientes'); 
});

router.get('/listar-produtos', (req, res) => {
  res.render('listar-produtos'); 
});

router.get('/listar-fornecedores', (req, res) => {
  res.render('listar-fornecedores'); 
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

router.get('/listar-clientes-backend', async (req, res) => {
  try {
    const response = await axios.get('http://localhost:8080/api/clientes/get-all-clientes');
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar clientes do backend Java' });
    console.error(error.message);
  }
})

router.get('/listar-produtos-backend', async (req, res) => {
  try {
    const response = await axios.get('http://localhost:8080/api/produtos/get-all-produtos');
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar produtos do backend Java' });
    console.error(error.message);
  }
})

router.get('/listar-fornecedores-backend', async (req, res) => {
  try {
    const response = await axios.get('http://localhost:8080/api/fornecedores/get-all-fornecedores');
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar fornecedores do backend Java' });
    console.error(error.message);
  }
})

router.delete('/deletar-cliente-backend/:id', async (req, res) => {
  const { id } = req.params;
  if (!id) {
    return res.status(400).json({ erro: 'ID do cliente é obrigatório' });
  }

  try {
    const response = await axios.delete(`http://localhost:8080/api/clientes/deletar-cliente/${id}`);
    res.json({ mensagem: 'Cliente deletado com sucesso', dados: response.data });
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao deletar cliente do backend Java' });
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

router.delete('/deletar-fornecedor-backend/:id', async (req, res) => {
  const { id } = req.params;
  if (!id) {
    return res.status(400).json({ erro: 'ID do fornecedor é obrigatório' });
  }

  try {
    const response = await axios.delete(`http://localhost:8080/api/fornecedores/deletar-fornecedor/${id}`);
    res.json({ mensagem: 'Fornecedor deletado com sucesso', dados: response.data });
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao deletar fornecedor do backend Java' });
  }
});

module.exports = router;