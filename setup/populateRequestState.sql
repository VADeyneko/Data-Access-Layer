INSERT INTO VACATION.REQUESTSTATE (ID, "NAME", isManagerState ,glyphoiconName, msg_subj, msg_body) 
	VALUES (1, 'StateForming' , 0,  'glyphicon-edit',  'msg.subj.StateForming',   'msg.body.StateForming');
INSERT INTO VACATION.REQUESTSTATE (ID, "NAME" , isManagerState,glyphoiconName, msg_subj, msg_body) 
	VALUES (2, 'StateRequested',0 , 'glyphicon-send',  'msg.subj.StateRequested',   'msg.body.StateRequested' );
INSERT INTO VACATION.REQUESTSTATE (ID, "NAME" , isManagerState,glyphoiconName, msg_subj, msg_body) 
	VALUES (3, 'StateApproved' ,1, 'glyphicon-thumbs-up',  'msg.subj.StateApproved',   'msg.body.StateApproved');
INSERT INTO VACATION.REQUESTSTATE (ID, "NAME", isManagerState ,glyphoiconName, msg_subj, msg_body ) 
	VALUES (4, 'StateDisapproved',1 , 'glyphicon-thumbs-down',  'msg.subj.StateDisapproved',   'msg.body.StateDisapproved');
 
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
