const express = require('express');
const injuriesDeathsController = require('../controllers/injuriesDeaths');
const router = express.Router();

router.get('/', injuriesDeathsController.getInjuriesDeaths);


module.exports = router