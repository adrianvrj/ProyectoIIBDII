const express = require('express');
const decadeController = require('../controllers/decade_poblation');
const router = express.Router();

router.get('/', decadeController.getDecadePoblation);


module.exports = router