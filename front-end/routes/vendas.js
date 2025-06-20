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

module.exports = router;