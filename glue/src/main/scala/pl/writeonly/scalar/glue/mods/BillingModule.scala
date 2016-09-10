package pl.writeonly.scalar.glue.mods

import com.google.inject.AbstractModule

import pl.writeonly.scalar.glue.apps._

import com.typesafe.scalalogging.slf4j.StrictLogging

object BindingModule extends App with StrictLogging {

 //   val injector = Guice.createInjector(new BillingModule());
 //   BillingService billingService = injector.getInstance(BillingService.class);
    
}

class BillingModule extends AbstractModule {
  @Override 
  protected def configure() {
    bind(classOf[AppWindow])
     /*
      * This tells Guice that whenever it sees a dependency on a TransactionLog,
      * it should satisfy the dependency using a DatabaseTransactionLog.
      */
//    bind(TransactionLog.class).to(DatabaseTransactionLog.class);

     /*
      * Similarly, this binding tells Guice that when CreditCardProcessor is used in
      * a dependency, that should be satisfied with a PaypalCreditCardProcessor.
      */
//    bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
  }
}
