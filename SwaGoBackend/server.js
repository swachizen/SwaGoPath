
const express = require('express');
const app = express();
const fs = require('fs');
const path = require('path');

app.use(express.urlencoded({ extended: true }));
app.use(express.json());

const PORT = process.env.PORT || 8080;
const devices = [];

app.post('/register', (req, res) => {
    const { device_name } = req.body;
    if (device_name) {
        const entry = { device_name, time: new Date().toISOString() };
        devices.push(entry);
        console.log('Device Registered:', entry);
        res.status(200).send('OK');
    } else {
        res.status(400).send('Missing device_name');
    }
});

app.get('/devices', (req, res) => {
    res.json(devices);
});

app.listen(PORT, () => {
    console.log(`SwaGo backend listening at http://localhost:${PORT}`);
});
