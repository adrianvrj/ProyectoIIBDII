const express = require('express');
const fatalityBirthDecadeCountryQuintilController = require('../controllers/fatalityBirthDecadeCountryQuintil');
const router = express.Router();

router.get('/', fatalityBirthDecadeCountryQuintilController.getFatalityBirthDecadeCountryQuintil);


module.exports = router