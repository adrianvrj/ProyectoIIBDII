const express = require('express');
// const checkAuth = require('../Middleware/checkAuth.middleware');
const fertilityRate = require('../controllers/fertitlity_rate_country_decade');
const router = express.Router();

router.get('/', fertilityRate.getFertilityRate);


module.exports = router