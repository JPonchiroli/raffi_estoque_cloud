const express = require('express');
const axios = require('axios');
const router = express.Router();

router.post('/cadastrar-fornecedor-backend', async (req, res) => {
    try {
        const fornecedorData = {
            nomeFornecedor: req.body.nome,
            cnpj: req.body.cnpj,
            email: req.body.email,
            telefone: req.body.telefone,
            cep: req.body.cep,
            numeroRua: req.body.numeroRua,
            complemento: req.body.complemento || null
        };

        const response = await axios.post(
            'http://backend:8080/api/fornecedores/create-fornecedor',
            fornecedorData
        );

        res.json(response.data);

    } catch (error) {
        console.error('Erro ao cadastrar fornecedor no backend Java:', error);

        if (error.response) {
            res.status(error.response.status).json({
                erro: error.response.data.message || 'Erro ao cadastrar fornecedor no backend Java (resposta com erro)'
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

router.get('/listar-fornecedores-backend', async (req, res) => {
    try {
        const response = await axios.get('http://backend:8080/api/fornecedores/get-all-fornecedores');
        res.json(response.data);
    } catch (error) {
        res.status(500).json({ erro: 'Erro ao listar fornecedores do backend Java' });
        console.error(error.message);
    }
});

router.put('/atualizar-fornecedor-backend/:id', async (req, res) => {
    const codFornecedor = req.params.id;
    const { nomeFornecedor, cnpj, email, telefone, cep, numeroRua, complemento } = req.body;

    try {
        const response = await axios.put(`http://backend:8080/api/fornecedores/update-fornecedor/${codFornecedor}`, {
            nomeFornecedor,
            cnpj,
            email,
            telefone,
            cep,
            numeroRua,
            complemento
        });

        res.status(200).json({ mensagem: 'Fornecedor atualizado com sucesso!', dados: response.data });
    } catch (erro) {
        console.error('Erro ao atualizar fornecedor:', erro);
        res.status(500).json({ erro: 'Erro interno ao atualizar fornecedor' });
    }
});

router.delete('/deletar-fornecedor-backend/:id', async (req, res) => {
    const { id } = req.params;
    if (!id) {
        return res.status(400).json({ erro: 'ID do fornecedor é obrigatório' });
    }

    try {
        const response = await axios.delete(`http://backend:8080/api/fornecedores/deletar-fornecedor/${id}`);
        res.json({ mensagem: 'Fornecedor deletado com sucesso', dados: response.data });
    } catch (error) {
        console.error(error.message);
        res.status(500).json({ erro: 'Erro ao deletar fornecedor do backend Java' });
    }
});

router.get('/busca-fornecedores-nome-backend/:nomeFornecedor', async (req, res) => {
    const { nomeFornecedor } = req.params;
    if (!nomeFornecedor) {
        return res.status(400).json({ erro: 'Nome do fornecedor é obrigatório' });
    }

    try {
        const response = await axios.get(`http://backend:8080/api/fornecedores/get-fornecedor-nome/${nomeFornecedor}`);

        res.json(response.data);
    } catch (error) {
        console.error(error.message);
        res.status(500).json({ erro: 'Erro ao encontrar fornecedores' });
    }
});

router.get('/busca-fornecedor-id-backend/:id', async (req, res) => {
    const { id } = req.params;
    if (!id) {
        return res.status(400).json({ erro: 'Nome do fornecedor é obrigatório' });
    }

    try {
        const response = await axios.get(`http://backend:8080/api/fornecedores/get-fornecedor/${id}`);

        res.json(response.data);
    } catch (error) {
        console.error(error.message);
        res.status(500).json({ erro: 'Erro ao encontrar fornecedores' });
    }
});

module.exports = router;