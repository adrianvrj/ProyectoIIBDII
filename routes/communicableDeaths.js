const express = require('express');
const communicableDeathsController = require('../controllers/communicableDeaths');
const router = express.Router();

router.get('/', communicableDeathsController.getCommunicableDeaths);


module.exports = router