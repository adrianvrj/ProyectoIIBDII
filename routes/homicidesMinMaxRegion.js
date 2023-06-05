const express = require('express');
const homicidesMinMaxRegionController = require('../controllers/homicidesMinMaxRegion');
const router = express.Router();

router.get('/', homicidesMinMaxRegionController.getHomicidesMinMaxRegion);


module.exports = router