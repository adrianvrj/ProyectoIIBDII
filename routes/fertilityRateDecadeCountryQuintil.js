const express = require('express');
const fertilityRateDecadeCountryQuintilController = require('../controllers/fertilityRateDecadeCountryQuintil');
const router = express.Router();

router.get('/', fertilityRateDecadeCountryQuintilController.getFertilityRateDecadeCountryQuintil);


module.exports = router