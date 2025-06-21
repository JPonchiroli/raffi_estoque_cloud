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

router.get('/cadastro-venda', (req, res) => {
  res.render('cadastro-venda');
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

router.get('/listar-vendas', (req, res) => {
  res.render('listar-vendas');
});

router.get('/detalhes-venda', (req, res) => {
  res.render('detalhes-venda');
});

module.exports = router;