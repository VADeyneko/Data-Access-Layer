INSERT INTO VACATION.REQUESTSTATE (ID, "NAME", isManagerState ,glyphoiconName) 
	VALUES (1, 'StateForming' , 0,  'glyphicon-edit');
INSERT INTO VACATION.REQUESTSTATE (ID, "NAME" , isManagerState,glyphoiconName) 
	VALUES (2, 'StateRequested',0 , 'glyphicon-send' );
INSERT INTO VACATION.REQUESTSTATE (ID, "NAME" , isManagerState,glyphoiconName) 
	VALUES (3, 'StateApproved' ,1, 'glyphicon-thumbs-up');
INSERT INTO VACATION.REQUESTSTATE (ID, "NAME", isManagerState ,glyphoiconName ) 
	VALUES (4, 'StateDisapproved',1 , 'glyphicon-thumbs-down');
 
INSERT INTO VACATION.REQUESTSTATE_REQUESTSTATE (REQUESTSTATE_ID, POSSIBLESTATES_ID) 
	VALUES (1, 2);

INSERT INTO VACATION.REQUESTSTATE_REQUESTSTATE (REQUESTSTATE_ID, POSSIBLESTATES_ID) 
	VALUES (2, 3);

INSERT INTO VACATION.REQUESTSTATE_REQUESTSTATE (REQUESTSTATE_ID, POSSIBLESTATES_ID) 
	VALUES (2, 4);

INSERT INTO VACATION.REQUESTSTATE_REQUESTSTATE (REQUESTSTATE_ID, POSSIBLESTATES_ID) 
	VALUES (2, 1);

INSERT INTO VACATION.REQUESTSTATE_REQUESTSTATE (REQUESTSTATE_ID, POSSIBLESTATES_ID) 
	VALUES (3, 2);

INSERT INTO VACATION.REQUESTSTATE_REQUESTSTATE (REQUESTSTATE_ID, POSSIBLESTATES_ID) 
	VALUES (4, 2);
