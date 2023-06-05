const express = require('express');
const uncommunicableDeathsController = require('../controllers/uncommunicableDeaths');
const router = express.Router();

router.get('/', uncommunicableDeathsController.getUncommunicableDeaths);


module.exports = router