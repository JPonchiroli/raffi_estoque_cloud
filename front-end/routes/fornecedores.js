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
            'http://localhost:8080/api/fornecedores/create-fornecedor',
            fornecedorData
        );

        res.json(response.data);

    } catch (error) {
        console.error('Erro ao cadastrar fornecedor no backend Java:', error.message);
        if (error.response) {
            res.status(error.response.status).json({
                erro: error.response.data.message || 'Erro ao cadastrar fornecedor no backend Java'
            });
        } else if (error.request) {
            res.status(500).json({ erro: 'Nenhuma resposta recebida do backend Java' });
        } else {
            res.status(500).json({ erro: 'Erro ao configurar a requisição para o backend Java' });
        }
    }
});

router.get('/listar-fornecedores-backend', async (req, res) => {
    try {
        const response = await axios.get('http://localhost:8080/api/fornecedores/get-all-fornecedores');
        res.json(response.data);
    } catch (error) {
        res.status(500).json({ erro: 'Erro ao listar fornecedores do backend Java' });
        console.error(error.message);
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