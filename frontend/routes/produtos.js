const express = require('express');
const axios = require('axios');
const router = express.Router();


router.post('/cadastrar-produto-backend', async (req, res) => {
  try {
    const produtoData = {
      codigoBarras: req.body.codigoBarras,
      nomeProduto: req.body.nomeProduto,
      unidadeMedida: req.body.unidadeMedida,
      valorCusto: req.body.valorCusto,
      porcentagemLucro: req.body.porcentagemLucro,
      valorVenda: req.body.valorVenda,
      estoqueAtual: req.body.estoqueAtual,
      estoqueMinimo: req.body.estoqueMinimo,
      codFornecedor: req.body.codFornecedor
    };

    const response = await axios.post(
      'http://backend:8080/api/produtos/create-produto',
      produtoData
    );

    res.json(response.data);

  } catch (error) {
    console.error('Erro ao cadastrar produto no backend Java:', error);

    if (error.response) {
      res.status(error.response.status).json({
        erro: error.response.data.message || 'Erro ao cadastrar produto no backend Java (resposta com erro)'
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

router.get('/listar-produtos-backend', async (req, res) => {
  try {
    const response = await axios.get('http://backend:8080/api/produtos/get-all-produtos');
    res.json(response.data);
  } catch (error) {
    res.status(500).json({ erro: 'Erro ao listar produtos do backend Java' });
    console.error(error.message);
  }
});

router.get('/busca-produtos-codigo-barras-backend/:codigoBarras', async (req, res) => {
  const { codigoBarras } = req.params;
  if (!codigoBarras) {
    return res.status(400).json({ erro: 'Nome do produto é obrigatório' });
  }

  try {
    const response = await axios.get(`http://backend:8080/api/produtos/get-produto-cod-barras/${codigoBarras}`);

    console.log('Resposta do Spring:', response.data);

    res.json(Array.isArray(response.data) ? response.data : [response.data]);
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao encontrar produtos' });
  }
});

router.put('/atualizar-produto-backend/:id', async (req, res) => {
  const codProduto = req.params.id;
  const { codigoBarras, nomeProduto, unidadeMedida, valorCusto, porcentagemLucro, valorVenda, estoqueAtual, estoqueMinimo } = req.body;

  try {
    const response = await axios.put(`http://backend:8080/api/produtos/update-produto/${codProduto}`, {
      codigoBarras,
      nomeProduto,
      unidadeMedida,
      valorCusto,
      porcentagemLucro,
      valorVenda,
      estoqueAtual,
      estoqueMinimo
    });

    res.status(200).json({ mensagem: 'Produto atualizado com sucesso!', dados: response.data });
  } catch (erro) {
    console.error('Erro ao atualizar produto:', erro);
    res.status(500).json({ erro: 'Erro interno ao atualizar produto' });
  }
});

router.delete('/deletar-produto-backend/:id', async (req, res) => {
  const { id } = req.params;
  if (!id) {
    return res.status(400).json({ erro: 'ID do produto é obrigatório' });
  }

  try {
    const response = await axios.delete(`http://backend:8080/api/produtos/deletar-produto/${id}`);
    res.json({ mensagem: 'Produto deletado com sucesso', dados: response.data });
  } catch (error) {
    console.error(error.message);
    res.status(500).json({ erro: 'Erro ao deletar produto do backend Java' });
  }
});

module.exports = router;