package com.gu.contentatom.renderer
package renderers

import com.gu.contentatom.thrift.Atom
import com.gu.contentatom.thrift.atom.chart.ChartAtom
import com.gu.contentatom.thrift.atom.commonsdivision.CommonsDivision
import com.gu.contentatom.thrift.atom.cta.CTAAtom
import com.gu.contentatom.thrift.atom.explainer.ExplainerAtom
import com.gu.contentatom.thrift.atom.guide.GuideAtom
import com.gu.contentatom.thrift.atom.interactive.InteractiveAtom
import com.gu.contentatom.thrift.atom.media.MediaAtom
import com.gu.contentatom.thrift.atom.profile.ProfileAtom
import com.gu.contentatom.thrift.atom.qanda.QAndAAtom
import com.gu.contentatom.thrift.atom.quiz.QuizAtom
import com.gu.contentatom.thrift.atom.recipe.RecipeAtom
import com.gu.contentatom.thrift.atom.review.ReviewAtom
import com.gu.contentatom.thrift.atom.timeline.TimelineAtom
import com.gu.contentatom.thrift.atom.audio.AudioAtom

import play.twirl.api.Html

trait DefaultRendering[A] extends Rendering[A] {
  type Conf = NilConfiguration
  
  def html[C <: Conf](atom: Atom, data: A)(implicit conf: C) = html_impl(atom, data)
  def css = None
  def js = None

  def html_impl: (Atom, A) => Html
}

object DefaultRenderings extends Renderings {
  val ctaRendering = new DefaultRendering[CTAAtom] {
    val html_impl = (atom, data) => cta.default.html.index(atom, data)
  }

  val explainerRendering = new DefaultRendering[ExplainerAtom] {
    val html_impl = (atom, data) => explainer.default.html.index(atom, data)
  }

  val guideRendering = new DefaultRendering[GuideAtom] {
    val html_impl = (atom, data) => guide.default.html.index(atom, data)
  }

  val interactiveRendering = new DefaultRendering[InteractiveAtom] {
    val html_impl = (atom, data) => interactive.default.html.index(atom, data)
  }

  val mediaRendering = new DefaultRendering[MediaAtom] {
    val html_impl = (atom, data) => media.default.html.index(atom, data)
  }

  val profileRendering = new DefaultRendering[ProfileAtom] {
    val html_impl = (atom, data) => profile.default.html.index(atom, data)
  }

  val qandaRendering = new DefaultRendering[QAndAAtom] {
    val html_impl = (atom, data) => qanda.default.html.index(atom, data)
  }

  val quizRendering = new DefaultRendering[QuizAtom] {
    val html_impl = (atom, data) => quiz.default.html.index(atom, data)
  }

  val recipeRendering = new DefaultRendering[RecipeAtom] {
    val html_impl = (atom, data) => recipe.default.html.index(atom, data)
  }

  val reviewRendering = new DefaultRendering[ReviewAtom] {
    val html_impl = (atom, data) => review.default.html.index(atom, data)
  }

  val timelineRendering = new DefaultRendering[TimelineAtom] {
    val html_impl = (atom, data) => timeline.default.html.index(atom, data)
  }

  val commonsdivisionRendering = new DefaultRendering[CommonsDivision] {
    val html_impl = (atom, data) => commonsdivision.default.html.index(atom, data)
  }

  val chartRendering = new DefaultRendering[ChartAtom] {
    val html_impl = (atom, data) => chart.default.html.index(atom, data)
  }

  val audioRendering = new DefaultRendering[AudioAtom] {
    val html_impl = (atom, data) => audio.default.html.index(atom, data)
  }
}
