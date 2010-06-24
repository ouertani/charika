package net.dikka.charika.blueprint
package reflect.impl

import org.osgi.service.blueprint.reflect.ReferenceListMetadata

trait TReferenceListMetadata extends ReferenceListMetadata with TServiceReferenceMetadata


case class ReferenceListMetadataImpl (memberType : MemberType)extends TReferenceMetadata