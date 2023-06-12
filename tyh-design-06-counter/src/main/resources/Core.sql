CREATE
OR REPLACE VIEW vded_coupon_core AS
SELECT concat(concat(`a`.`EXHACC`, '_'), `a`.`CURRENCY`)               AS `I_CODE`,
       'SPT_DED'                                                       AS `A_TYPE`,
       'X_CNBD'                                                        AS `M_TYPE`,
       '0304'                                                          AS `P_TYPE`,
       (
           CASE

               WHEN (`b`.`COUPON_TYPE` = '1') THEN
                   `c`.`RATE`
               WHEN (`b`.`COUPON_TYPE` = '2') THEN
                   ((`b`.`RATE_MULTI` * `trd`.`d`.`DP_CLOSE`) + `c`.`RATE`)
               ELSE `a`.`COUPON`
               END
           )                                                           AS `RATE`,
       COALESCE(`trd`.`d`.`BEG_DATE`, `c`.`BEG_DATE`, `a`.`OPEN_DATE`) AS `BEG_DATE`,
       COALESCE(`trd`.`d`.`END_DATE`, `c`.`END_DATE`, '2100-12-31')    AS `END_DATE`,
       `c`.`IMP_TIME`                                                  AS `IMP_TIME`
FROM (((
    `trd`.`ttrd_acc_cash_ext` `a`
        LEFT JOIN `trd`.`ttrd_ded_rate_def` `b` ON ((
        `b`.`ID` = `a`.`RATE_DEF_ID`
        )))
    LEFT JOIN `trd`.`ttrd_ded_rate` `c` ON ((
        `c`.`DEF_ID` = `a`.`RATE_DEF_ID`
        )))
         LEFT JOIN `trd`.`tir_series` `d` ON (((
                                                       `trd`.`d`.`I_CODE` =
                                                       regexp_substr(`b`.`BASE_RATE`, '[^,]+', 1, 1, 'i'))
    AND (
                                                       `trd`.`d`.`A_TYPE` =
                                                       regexp_substr(`b`.`BASE_RATE`, '[^,]+', 1, 2, 'i'))
    AND (
                                                       `trd`.`d`.`M_TYPE` =
                                                       regexp_substr(`b`.`BASE_RATE`, '[^,]+', 1, 3, 'i'))
    AND (`trd`.`d`.`BEG_DATE` > '2015-01-01')
    AND ((
             `trd`.`d`.`BEG_DATE` BETWEEN `c`.`BEG_DATE`
                 AND `c`.`END_DATE`
             )
        OR (`trd`.`d`.`END_DATE` BETWEEN `c`.`BEG_DATE` AND `c`.`END_DATE`)))))
WHERE (`a`.`PAYMENT_FREQ` <> '-1')
UNION ALL
SELECT concat(concat(`cash`.`EXHACC`, '_'), `cash`.`CURRENCY`) AS `I_CODE`,
       'SPT_DED'                                               AS `A_TYPE`,
       'X_CNBD'                                                AS `M_TYPE`,
       '0300'                                                  AS `P_TYPE`,
       0                                                       AS `RATE`,
       '1901-01-01'                                            AS `BEG_DATE`,
       '2100-12-31'                                            AS `END_DATE`,
       ''                                                      AS `IMP_TIME`
FROM `trd`.`ttrd_acc_cash_ext` `cash`
WHERE (`cash`.`PAYMENT_FREQ` = '-1')
UNION ALL
SELECT `a`.`I_CODE`      AS                  `I_CODE`,
       `a`.`A_TYPE`      AS                  `A_TYPE`,
       `a`.`M_TYPE`      AS                  `M_TYPE`,
       `a`.`P_TYPE`      AS                  `P_TYPE`,
       `b`.`VOLUME`      AS                  `RATE`,
       `b`.`BEG_DATE`    AS                  `BEG_DATE`,
       lead(`b`.`BEG_DATE`, 1, '2100-12-31') OVER ( PARTITION BY `b`.`I_CODE`, `b`.`A_TYPE`, `b`.`M_TYPE` ORDER BY `b`.`BEG_DATE` ) AS `END_DATE`,
       `b`.`UPDATE_TIME` AS                  `UPDATE_TIME`
FROM (
      `trd`.`ttrd_wmps_define` `a`
         JOIN `trd`.`ttrd_instrument_extend` `b` ON (((
                                                          `a`.`P_TYPE` = '0301'
                                                          )
    AND (`a`.`I_CODE` = `b`.`I_CODE`)
    AND (`a`.`A_TYPE` = `b`.`A_TYPE`)
    AND (`a`.`M_TYPE` = `b`.`M_TYPE`)
    AND (`b`.`EXTEND_TYPE` = '02'))))
UNION ALL
SELECT `fee`.`I_CODE`  AS                    `I_CODE`,
       `fee`.`A_TYPE`  AS                    `A_TYPE`,
       `fee`.`M_TYPE`  AS                    `M_TYPE`,
       `inst`.`P_TYPE` AS                    `P_TYPE`,
       `r`.`VOLUME`    AS                    `RATE`,
       `r`.`BEG_DATE`  AS                    `BEG_DATE`,
       lead(`r`.`BEG_DATE`, 1, '2100-12-31') OVER ( PARTITION BY `r`.`I_CODE`, `r`.`A_TYPE`, `r`.`M_TYPE` ORDER BY `r`.`BEG_DATE` ) AS `END_DATE`,
       `r`.`IMP_TIME`  AS                    `IMP_TIME`
FROM `trd`.`ttrd_instrument_extend` `r`
         JOIN `trd`.`ttrd_wmps_fee` `fee`
         JOIN `trd`.`ttrd_wmps_define` `d`
         JOIN `trd`.`ttrd_instrument` `inst`
WHERE ((
           `r`.`I_CODE` = `fee`.`I_CODE`
           )
    AND (`r`.`A_TYPE` = `fee`.`A_TYPE`)
    AND (`r`.`M_TYPE` = `fee`.`M_TYPE`)
    AND (`r`.`EXTEND_TYPE` = '02')
    AND (`fee`.`I_CODE` = `inst`.`I_CODE`)
    AND (`fee`.`A_TYPE` = `inst`.`A_TYPE`)
    AND (`fee`.`M_TYPE` = `inst`.`M_TYPE`)
    AND (`fee`.`W_I_CODE` = `d`.`I_CODE`)
    AND (`fee`.`W_A_TYPE` = `d`.`A_TYPE`)
    AND (`fee`.`W_M_TYPE` = `d`.`M_TYPE`))
UNION ALL
SELECT `a`.`I_CODE`                         AS `I_CODE`,
       `a`.`A_TYPE`                         AS `A_TYPE`,
       `a`.`M_TYPE`                         AS `M_TYPE`,
       `a`.`P_TYPE`                         AS `P_TYPE`,
       ifnull(`b`.`YIELD_7D`, 0)            AS `RATE`,
       ifnull(`b`.`BEG_DATE`, '1950-01-01') AS `BEG_DATE`,
       ifnull(`b`.`END_DATE`, '2050-12-31') AS `END_DATE`,
       ifnull(`b`.`IMP_DATE`, '1950-01-01') AS `IMP_DATE`
FROM (
      `trd`.`ttrd_equity` `a`
         LEFT JOIN `trd`.`ttrd_equity_nav` `b` ON (((
                                                        `b`.`I_CODE` = `a`.`I_CODE`
                                                        )
    AND (`b`.`A_TYPE` = `a`.`A_TYPE`)
    AND (`b`.`M_TYPE` = `a`.`M_TYPE`))))
WHERE ((
           `a`.`A_TYPE` = 'SPT_DED'
           )
    AND (`a`.`P_TYPE` = '0312'))
UNION ALL
SELECT `c`.`I_CODE`                                              AS `I_CODE`,
       `c`.`A_TYPE`                                              AS `A_TYPE`,
       `c`.`M_TYPE`                                              AS `M_TYPE`,
       (
           CASE
               `trd`.`a`.`A_TYPE`
               WHEN 'SPT_MMF' THEN
                   '0706'
               ELSE NULL
               END
           )                                                     AS `P_TYPE`,
       ifnull(`trd`.`a`.`F_PROFIT_1W`, 0)                        AS `RATE`,
       ifnull(`trd`.`a`.`BEG_DATE`, '1950-01-01')                AS `BEG_DATE`,
       ifnull(`ADD_DAYS`(`trd`.`a`.`BEG_DATE`, 1), '2050-12-31') AS `END_DATE`,
       ifnull(`trd`.`a`.`IMP_DATE`, '1950-01-01')                AS `IMP_DATE`
FROM (
      `trd`.`tfnd_nav` `a`
         LEFT JOIN `trd`.`ttrd_asset_lmn_info` `c` ON (((
                                                            `trd`.`a`.`I_CODE` = `c`.`BOTTOM_I_CODE`
                                                            )
    AND (`trd`.`a`.`A_TYPE` = `c`.`A_TYPE`)
    AND (`trd`.`a`.`M_TYPE` = `c`.`BOTTOM_M_TYPE`))))
WHERE EXISTS(
              SELECT 1
              FROM `trd`.`ttrd_blc_secu_obj` `b`
              WHERE ((
                         `c`.`I_CODE` = `b`.`I_CODE`
                         )
                  AND (`c`.`A_TYPE` = `b`.`A_TYPE`)
                  AND (`c`.`M_TYPE` = `b`.`M_TYPE`)))
UNION ALL
SELECT `trd`.`a`.`I_CODE` AS `I_CODE`,
       `trd`.`a`.`A_TYPE` AS `A_TYPE`,
       `trd`.`a`.`M_TYPE` AS `M_TYPE`,
       `trd`.`a`.`P_TYPE` AS `P_TYPE`,
       `d`.`RATE`         AS `RATE`,
       `d`.`BEG_DATE`     AS `BEG_DATE`,
       `d`.`END_DATE`     AS `END_DATE`,
       `d`.`IMP_TIME`     AS `IMP_TIME`
FROM (
      `trd`.`v_asset_fee` `a`
         JOIN `trd`.`ttrd_ded_rate` `d` ON ((
    `d`.`DEF_ID` = `trd`.`a`.`RATE_ID`
    )));