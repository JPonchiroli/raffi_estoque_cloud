const express = require('express');
const app = express();
const port = 3000;

app.set('view engine', 'ejs');

app.use(express.static('public'));

const pagesRouter = require('../routes/pages');
app.use('/', pagesRouter);

app.listen(3000, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
