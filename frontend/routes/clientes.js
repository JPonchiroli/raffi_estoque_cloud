const express = require('express');
const axios = require('axios');
const router = express.Router();

router.post('/cadastrar-cliente-backend', async (req, res) => {
  try {
    const clienteData = {
      nomeCliente: req.body.nome,
      cep: req.body.cep,
      numeroRua: req.body.numeroRua,
      complemento: req.body.complemento || null
    };

    const response = await axios.post(
      'http://backend:8080/api/clientes/create-cliente',
      clienteData
    );

    res.json(response.data);
    
  } catch (error) {
    console.error('Erro ao cadastrar cliente no backend Java:', error);

    if (error.response) {
      res.status(error.response.status).json({
        erro: error.response.data.message || 'Erro ao cadastrar cliente no backend Java (resposta com erro)'
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

router.get('/listar-clientes-backend', async (req, res) => {
  try {
    const response = await axios.get('http://backend:8080/api/clientes/get-all-clientes');
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar clientes do backend Java' });
    console.error(error.message);
  }
});

router.get('/lista-cliente-id-backend/:id', async (req, res) => {
  const { id } = req.params;
  if (!id) {
    return res.status(400).json({ erro: 'Id do cliente é obrigatório' });
  }

  try {
    const response = await axios.get(`http://backend:8080/api/clientes/get-cliente/${id}`);
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar clientes do backend Java' });
    console.error(error.message);
  }
});

router.get('/busca-clientes-nome-backend/:nomeCliente', async (req, res) => {
  const { nomeCliente } = req.params;
  if (!nomeCliente) {
    return res.status(400).json({ erro: 'Nome do cliente é obrigatório' });
  }

  try {
    const response = await axios.get(`http://backend:8080/api/clientes/get-cliente-nome/${nomeCliente}`);

    console.log('Resposta do Spring:', response.data);

    res.json(response.data);
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao encontrar clientes' });
  }
});

router.put('/atualizar-cliente-backend/:id', async (req, res) => {
  const codCliente = req.params.id;
  const { nomeCliente, cep, numeroRua, complemento } = req.body;

  try {
    const response = await axios.put(`http://backend:8080/api/clientes/update-cliente/${codCliente}`, {
      nomeCliente,
      cep,
      numeroRua,
      complemento
    });

    res.status(200).json({ mensagem: 'Cliente atualizado com sucesso!', dados: response.data });
  } catch (erro) {
    console.error('Erro ao atualizar cliente:', erro);
    res.status(500).json({ erro: 'Erro interno ao atualizar cliente' });
  }
});

router.delete('/deletar-cliente-backend/:id', async (req, res) => {
  const { id } = req.params;
  if (!id) {
    return res.status(400).json({ erro: 'ID do cliente é obrigatório' });
  }

  try {
    const response = await axios.delete(`http://backend:8080/api/clientes/deletar-cliente/${id}`);
    res.json({ mensagem: 'Cliente deletado com sucesso', dados: response.data });
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao deletar cliente do backend Java' });
  }
});


module.exports = router;