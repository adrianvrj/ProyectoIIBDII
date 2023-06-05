const express = require('express');
const homicidesMinMaxSubregionController = require('../controllers/homicidesMinMaxSubregion');
const router = express.Router();

router.get('/', homicidesMinMaxSubregionController.getHomicidesMinMaxSubregion);


module.exports = router