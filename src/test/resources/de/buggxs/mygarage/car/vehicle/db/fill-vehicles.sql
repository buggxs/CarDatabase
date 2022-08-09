INSERT INTO `brands` (id, name, url)
VALUES (1, 'VW', '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/?filter=ONLY_RECENT&sort=SORTING_DESC'),
       (2, 'Mercedes', '/rund-ums-fahrzeug/autokatalog/marken-modelle/mercedes/?filter=ONLY_RECENT&sort=SORTING_DESC');


INSERT INTO `model_series` (id, name, url, brand_id)
VALUES (1, 'Arteon', '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/arteon/?filter=ONLY_RECENT&sort=SORTING_DESC',
        1),
       (2, 'Golf', '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/golf/?filter=ONLY_RECENT&sort=SORTING_DESC', 1),
       (9, 'Tiguan', '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/tiguan/?filter=ONLY_RECENT&sort=SORTING_DESC',
        1),
       (81, 'C-Klasse',
        '/rund-ums-fahrzeug/autokatalog/marken-modelle/mercedes/c-klasse/?filter=ONLY_RECENT&sort=SORTING_DESC', 2);


INSERT INTO `model_series_generation` (id, name, url, model_series_id)
VALUES (2, 'Arteon 1.Generation', '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/arteon/1generation/', 1),
       (3, 'Golf VIII', '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/golf/viii/', 2),
       (49, 'Tiguan I', '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/tiguan/i/', 9),
       (246, 'C-Klasse 204', '/rund-ums-fahrzeug/autokatalog/marken-modelle/mercedes-benz/c-klasse/204/', 81);


INSERT INTO `vehicles` (id, name, model, type, url, model_series_generation_id)
VALUES (1, 'Arteon  (3H)', NULL, 'VW Arteon 1.4 eHybrid OPF Elegance DSG (ab 11/20)',
        '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/arteon/1generation-facelift/318177/', 2),
       (106, 'Golf  (CD)', NULL, 'VW Golf 1.5 eTSI R-Line DSG (ab 12/20)',
        '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/golf/viii/318361/', 3),
       (9703, 'Tiguan  (5N)', NULL, 'VW Tiguan 1.5 TSI OPF URBAN SPORT DSG (ab 07/21)',
        '/rund-ums-fahrzeug/autokatalog/marken-modelle/vw/tiguan/ii-facelift/321215/', 49),
       (30857, 'C-Klasse Limousine (W204)', NULL, 'Mercedes C 180 BlueEFFICIENCY Elegance (04/12 - 02/13)',
        '/rund-ums-fahrzeug/autokatalog/marken-modelle/mercedes/c-klasse/204-facelift/231993/', 246);

INSERT INTO `vehicles_details` (id, vehicle_id, type, model_start, model_end, model_series_start, model_series_end,
                                hsn_key, tsn_key, kfz_tax, base_price)
VALUES (2, 1, 'Elegance DSG', '11/20', NULL, '11/20', NULL, '0603', 'COQ', NULL, '49385 Euro'),
       (107, 106, 'R-Line DSG', '12/20', NULL, '12/19', NULL, '0603', 'CPJ', NULL, '32345 Euro'),
       (9703, 9703, 'URBAN SPORT DSG', '07/21', NULL, '09/20', NULL, '0603', 'CIR', NULL, '37080 Euro'),
       (30857, 30857, 'Elegance', '04/12', NULL, '03/11', NULL, '1313', 'DZD', NULL, '35254 Euro');

INSERT INTO `vehicles_details_technically` (id, vehicle_id, engine_type, engine_code, rated_capacity,
                                            kW_system_performance, PS_system_performance, torque, fuel_type,
                                            fuel_type_2, drive_type, gear_type, gear_amount, emission_class,
                                            position_engine, exhaust_gas_cleaning, amount_cylinders,
                                            mixture_preparation, engine_loading, amount_valves, displacement,
                                            max_power_rpm, max_torque_rpm)
VALUES (2, 1, 'PlugIn-Hybrid', '*DGE*', NULL, '160', '218', '400 Nm', 'Super', 'Strom (kWh)', 'Front',
        'Automat. Schaltgetriebe (Doppelkupplung)', '6', 'Euro 6d-ISC-FCM (WLTP) 36AP-AR', 'Frontmotor / Reihe',
        'Otto-Partikelfilter', '4', 'Direkteinspritzung', 'Turbo', '4', '1395 ccm', '5000 U/min', '1550 U/min'),
       (107, 106, 'Otto (Mild-Hybrid)', '*DPB*', NULL, '96', '130', '200 Nm', 'Super', NULL, 'Front',
        'Automat. Schaltgetriebe (Doppelkupplung)', '6', 'Euro 6d-ISC-FCM (WLTP) 36AP-AR', 'Frontmotor / Reihe',
        'Otto-Partikelfilter', '4', 'Direkteinspritzung', 'Turbo', '4', '1498 ccm', '5000 U/min', '1400 U/min'),
       (9706, 9703, 'Otto', '*DPC*', NULL, '110', '150', '250 Nm', 'Super', NULL, 'Front',
        'Automat. Schaltgetriebe (Doppelkupplung)', '7', 'Euro 6d-ISC-FCM (WLTP) 36AP-AR', 'Frontmotor / Reihe',
        'Otto-Partikelfilter', '4', 'Direkteinspritzung', 'Turbo', '4', '1498 ccm', '5000 U/min', '1500 U/min'),
       (30860, 30857, 'Otto', '274910', NULL, '115', '156', '250 Nm', 'Super', NULL, 'Heck', 'Schaltgetriebe', '6',
        'Euro 5', 'Frontmotor / Reihe', 'geregelt', '4', 'Direkteinspritzung', 'Turbo', '4', '1595 ccm', '5300 U/min',
        '1250 U/min');
