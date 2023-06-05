const express = require('express');
const fertilityDecadeCountry = require('../controllers/fertilityDecadeCountry');
const router = express.Router();

router.get('/', fertilityDecadeCountry.getFertilityDecadeCountry);


module.exports = router