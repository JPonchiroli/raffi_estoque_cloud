const express = require('express');
const cors = require('cors')
const app = express();
const port = 3000;

app.set('view engine', 'ejs');

app.use(express.static('public'));

app.use(cors());
app.use(express.json());

const pagesRouter = require('../routes/pages');
const clientesRouter = require('../routes/clientes');
const fornecedoresRouter = require('../routes/fornecedores');
const produtosRouter = require('../routes/produtos');
const vendasRouter = require('../routes/vendas');
const utilsRouter = require('../routes/utils');

app.use('/', pagesRouter);                     
app.use('/clientes', clientesRouter);           
app.use('/fornecedores', fornecedoresRouter);  
app.use('/produtos', produtosRouter);  
app.use('/vendas', vendasRouter);
app.use('/utils', utilsRouter);                

app.listen(3000, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
