const express = require('express');
const cors = require('cors')
const app = express();
const port = 3000;

app.set('view engine', 'ejs');

app.use(express.static('public'));

app.use(cors());
app.use(express.json());

const pagesRouter = require('../routes/pages');
app.use('/', pagesRouter);

app.listen(3000, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
