const cors = require('cors');

app.use(cors({
  origin: 'http://localhost:8000',
  credentials: true,
}));