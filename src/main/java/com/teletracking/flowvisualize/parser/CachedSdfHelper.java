package com.teletracking.flowvisualize.parser;

public enum CachedSdfHelper {

	appointmentreadstore( "appointmentreadstore" ),
	microservicestaffassignment( "microservice-staffassignment" ),
	microservicecautionmanagement( "microservice-cautionmanagement" ),
	microservicestaffassignmentaggregator( "microservice-staffassignmentaggregator" ),
	microservicecommandstatus( "microservice-commandstatus" ),
	microservicestaffassignmentorchestrator( "microservice-staffassignmentorchestrator" ),
	microservicecoverageassignment( "microservice-coverageassignment" ),
	microservicestaffavailability( "microservice-staffavailability" ),
	microservicecoverageassignmentaggregator( "microservice-coverageassignmentaggregator" ),
	microservicestaffcoverage( "microservice-staffcoverage" ),
	microservicecoverageassignmentorchestrator( "microservice-coverageassignmentorchestrator" ),
	microserviceuserpreferences( "microservice-userpreferences" ),
	microservicegenericeventlookup( "microservice-genericeventlookup" ),
	microserviceuserpreferencesreadstore( "microservice-userpreferencesreadstore" ),
	microservicejob( "microservice-job" ),
	microserviceworkflowcompilerorchestrator( "microservice-workflowcompilerorchestrator" ),
	microservicejoborchestrator( "microservice-joborchestrator" ),
	microserviceworkflowpreprocessor( "microservice-workflowpreprocessor" ),
	microservicelocationreservation( "microservice-locationreservation" ),
	microservicebedcleaningworkflow( "microservice.bedcleaningworkflow" ),
	microservicelocationreservationorchestrator( "microservice-locationreservationorchestrator" ),
	microserviceeventsnooper( "microservice.eventsnooper" ),
	microservicelocresorchservtest( "microservice-locresorchservtest" ),
	microserviceexternallocationmapper( "microservice.externallocationmapper" ),
	microservicenooperationservice( "microservice-nooperationservice" ),
	microservicehl7orchestrator( "microservice.hl7orchestrator" ),
	microservicepatientprocedurejourneyconfiguration( "microservice-patientprocedurejourneyconfiguration" ),
	microservicehl7processor( "microservice.hl7processor" ),
	microservicepatientprocedurejourneysagaservice( "microservice-patientprocedurejourneysagaservice" ),
	microservicelocation( "microservice.location" ),
	microservicepatientprocedurejourneyservice( "microservice-patientprocedurejourneyservice" ),
	microservicepatient( "microservice.patient" ),
	microserviceperioperativeorchestrator( "microservice-perioperativeorchestrator" ),
	microservicepatientlocation( "microservice.patientlocation" ),
	microservicephiviewresultservice( "microservice-phiviewresultservice" ),
	microservicepatientprocedure( "microservice.patientprocedure" ),
	microserviceprocedureappointmentlocationaggregator( "microservice-procedureappointmentlocationaggregator" ),
	microservicepatientregistration( "microservice.patientregistration" ),
	microservicereadstoreappointmentcautions( "microservice-readstore-appointmentcautions" ),
	microserviceprocedureappointment( "microservice.procedureappointment" ),
	microservicereadstoreauthentication( "microservice-readstore-authentication" ),
	microservicereadstorebayassignment( "microservice.readstore.bayassignment" ),
	microservicereadstorecommandstatusreadstore( "microservice-readstore-commandstatusreadstore" ),
	microservicereadstoregridconfiguration( "microservice.readstore.gridconfiguration" ),
	microservicereadstorecreaterequest( "microservice-readstore-createrequest" ),
	microservicereadstoreisolation( "microservice.readstore.isolation" ),
	microservicereadstorepreassignment( "microservice-readstore-preassignment" ),
	microservicereadstorepatientdetails( "microservice.readstore.patientdetails" ),
	microservicereadstoreresponsibilityreadstore( "microservice-readstore-responsibilityreadstore" ),
	microservicereadstoreregistration( "microservice.readstore.registration" ),
	microservicereadstoresimilarrequestreadstore( "microservice-readstore-similarrequestreadstore" ),
	microservicereadstoreregistrationconfiguration( "microservice.readstore.registrationconfiguration" ),
	microservicereadstorestaffadmindetails( "microservice-readstore-staffadmindetails" ),
	microservicereadstorestafflisting( "microservice.readstore.stafflisting" ),
	microservicereadstorestaffadminlist( "microservice-readstore-staffadminlist" ),
	microservicereadstoretransfercaseaudit( "microservice.readstore.transfercaseaudit" ),
	microservicereadstoreunitstaffmanagement( "microservice-readstore-unitstaffmanagement" ),
	microservicereadstoretransfercasegrid( "microservice.readstore.transfercasegrid" ),
	microserviceregistrationorchestration( "microservice-registrationorchestration" ),
	microservicereadstoretransfercaselog( "microservice.readstore.transfercaselog" ),
	microserviceregistrationworkflow( "microservice-registrationworkflow" ),
	microservicereadstoreunitstaffbreakmanagement( "microservice.readstore.unitstaffbreakmanagement" ),
	microserviceresponsibility( "microservice-responsibility" ),
	microservicetaskdefinition( "microservice.taskdefinition" ),
	microserviceskill( "microservice-skill" ),
	rainmakernotificationgeneration( "rainmaker.notification.generation" ),
	microservicestaff( "microservice-staff" ),
	uicomposerreadstore( "uicomposerreadstore" );

	final String slug;

	CachedSdfHelper( String slug ) {
		this.slug = slug;
	}

	static boolean isCached( BitBucketRepository repository ) {
		for( CachedSdfHelper cachedSdf : CachedSdfHelper.values() )
			if ( cachedSdf.slug.equals( repository.getSlug() ) )
				return true;
		return false;
	}

}
