--DELETE FROM spot;
-- Here you can add in the orientation (using direction metric? degrees? of the angle of the break.
INSERT INTO spot(spot_id, name, latitude, longitude, beach_facing)
VALUES
(1, 'Thurso East', 58.5927, -3.5259, 330),
(2, 'Machrihanish', 55.4232, -5.7347, 280),
(3, 'Dunbar', 56.0006, -2.5142, 35),
(4, 'Arbroath', 56.5632, -2.5874, 135),
(5, 'Gullane', 56.0365, -2.8283, 315),
(6, 'Holy Island', 55.6781, -1.7997, 35);
